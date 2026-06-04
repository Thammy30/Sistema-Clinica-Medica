package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

public interface ICommand {

    void executar(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException;
}