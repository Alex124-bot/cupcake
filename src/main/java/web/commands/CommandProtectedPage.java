package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandProtectedPage extends Command
{
    public String role;
    public String pageToShow;
    int topping_id = 0;
    int bottom_id = 0;

    public CommandProtectedPage(String pageToShow, String role)
    {
        this.pageToShow = pageToShow;
        this.role = role;

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        if (topping_id > 0 && bottom_id > 0)
        {
            topping_id = (int) request.getAttribute("topping");
            bottom_id = (int) request.getAttribute("bottom");

        }
        return pageToShow;
    }

    public String getRole()
    {
        return role;
    }
}
