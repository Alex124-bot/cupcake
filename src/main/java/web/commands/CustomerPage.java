package web.commands;

import business.services.BasketItem;

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
            ArrayList<BasketItem> basket;
            int topId = 0;
            int botId = 0;
            int amount = 0;
            boolean cupcakeExists = false;
            try {
                topId = Integer.parseInt(request.getParameter("topping"));
                botId = Integer.parseInt(request.getParameter("bottom"));
                amount = Integer.parseInt(request.getParameter("amount"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            basket = (session.getAttribute("basket") == null) ?
                    new ArrayList<>() : (ArrayList<BasketItem>) session.getAttribute("basket");

            for (BasketItem bi : basket) {
                if (topId == bi.getToppingId() && botId == bi.getBottomId()) {
                    bi.addAmount(amount);
                    cupcakeExists = true;
                    break;
                }
            }
            if(!cupcakeExists) basket.add(new BasketItem(topId, botId, amount));
            session.setAttribute("basket", basket);
        }
        return pageToShow;
    }
}