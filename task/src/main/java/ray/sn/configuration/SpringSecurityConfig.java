package ray.sn.configuration;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import ray.sn.services.CustomUserDetailsService;

@Configuration
public class SpringSecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SpringSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Configuration principale de la sécurité Spring
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // Désactive la protection CSRF (nécessaire pour les API REST stateless)
                .csrf(csrf -> csrf.disable())
                // Désactive la gestion de session (JWT est stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Gestion des autorisations
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("auth/login", "/users/register").permitAll() // Autorise l'accès à ces endpoints
                        .anyRequest().authenticated() // Toutes les autres routes nécessitent une authentification
                )
                // Active l'authentification basique
                .httpBasic(httpBasic -> httpBasic.disable()) // Désactivé si tu utilises uniquement JWT
                // Active la gestion OAuth2 avec JWT
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())
                .build();
    }

    /**
     * Configuration de l'AuthenticationManager en utilisant AuthenticationConfiguration
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Encoder pour les mots de passe (BCrypt recommandé pour plus de sécurité)
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Clé secrète utilisée pour signer et vérifier les JWT (HS256)
    private final String jwtKey = "7iD/Q4E7jCcGJzwS0sqpf4suL9EWRXnKXKGDCbFc0CkkuaDA1i1/ptqMlGLumF39";

    /**
     * Décodeur JWT pour valider les tokens
     */
    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec secretKey = new SecretKeySpec(jwtKey.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    }

    /**
     * Encodeur JWT pour générer des tokens
     */
    @Bean
    public JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(jwtKey.getBytes()));
    }
}
