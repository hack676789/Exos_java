package ray.sn.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException() {
        super("Tâche non trouvée");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}




