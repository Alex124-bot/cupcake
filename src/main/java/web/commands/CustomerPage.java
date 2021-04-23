package web.commands;

import business.services.TempCake;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CustomerPage extends CommandProtectedPage {

    public CustomerPage(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (request.getParameter("topping") != null) {
            ArrayList<TempCake> tmpOrder;
            tmpOrder = (session.getAttribute("tmpOrder") == null) ?
                    new ArrayList<>() : (ArrayList<TempCake>) session.getAttribute("tmpOrder");
            tmpOrder.add(new TempCake(
                    Integer.parseInt(request.getParameter("topping")),
                    Integer.parseInt(request.getParameter("bottom")),
                    Integer.parseInt(request.getParameter("amount"))
            ));
            session.setAttribute("tmpOrder", tmpOrder);
        }
        return pageToShow;
    }
}