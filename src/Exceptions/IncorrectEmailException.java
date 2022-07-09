package Exceptions;

public class IncorrectEmailException extends Exception
{
    IncorrectEmailException()
    {
        super();
    }

    IncorrectEmailException(String message) {
        super(message);
    }
}
