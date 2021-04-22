package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderCommand extends CommandUnprotectedPage {
    private OrderFacade orderFacade;

    public OrderCommand(String pageToShow) {
        super(pageToShow);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int topping = 0;
        int bottom = 0;
        int amount = 0;
        int i = 0;

        try {
            topping = Integer.parseInt((request.getParameter("topping")));
            bottom = Integer.parseInt((request.getParameter("bottom")));
            amount = Integer.parseInt((request.getParameter("amount")));

        } catch (NumberFormatException ex) {
            request.setAttribute("error", "Husk at du skal indtaste to heltal i formularen");
            return "customerpage";
//            throw new UserException("Husk at du skal indtaste to heltal i formularen");
        }

        request.setAttribute("topping", topping);

//        if (topping == 1) {
//            topping_name = "Chocolate";
//        }
//        else if (topping == 2) {
//            topping_name = "Blueberry";
//        }
//        else if (topping == 3) {
//            topping_name = "Rasberry";
//        }
//        else if (topping == 4) {
//            topping_name = "Crispy";
//        }
//        else if (topping == 5) {
//            topping_name = "Strawberry";
//        }
//        else if (topping == 6) {
//            topping_name = "Rum/Raisin";
//        }
//        else if (topping == 7) {
//            topping_name = "Orange";
//        }
//        else if (topping == 8) {
//            topping_name = "Lemon";
//        }
//        else if (topping == 9) {
//            topping_name = "Blue cheese";
//        }

        request.setAttribute("bottom", bottom);
        request.setAttribute("amount", amount);

        orderFacade.insertOrderEntry(0 );


//            String topping_name_2 = "Blueberry";
//            String topping_name_3 = "Rasberry";
//            String topping_name_4 = "Crispy";
//            String topping_name_5 = "Strawberry";
//            String topping_name_6 = "Rum/Raisin";
//            String topping_name_7 = "Orange";
//            String topping_name_8 = "Lemon";
//            String topping_name_9 = "Blue cheese";


//        int user_id = 1; // TODO skal laves til dynamisk i forhold til login
//        int price = 0;
//        int created = 0;
//        int completed = 0;
//
//        String[] hobbies = request.getParameterValues("hobby");
//        List<String> hobbyListStrings = null;
//        if (hobbies != null)
//        {
//            hobbyListStrings = Arrays.asList(hobbies);
//        }
//
//        List<Integer> hobbyListIntegers = new ArrayList<>();
//
//        for (String hobbyListItem : hobbyListStrings)
//        {
//            hobbyListIntegers.add(Integer.parseInt(hobbyListItem));
//        }
//
//        try {
//            height = Double.parseDouble(request.getParameter("height"));
//            weight = Double.parseDouble(request.getParameter("weight"));
//
//        }
//        catch (NumberFormatException ex)
//        {
//            request.setAttribute("error", "Husk at du skal indtaste to heltal i formularen");
//            return "index";
////            throw new UserException("Husk at du skal indtaste to heltal i formularen");
//        }
//
//
//
//        request.setAttribute("created", weight);
//        request.setAttribute("completed", category);
//        request.setAttribute("created", weight);
//        request.setAttribute("completed", category);
////        request.setAttribute("gender", gender);
////        request.setAttribute("sport_id", sport_id);
////        request.setAttribute("hobbies", hobbyListIntegers);
//
//        orderFacade.insertOrderEntry(bmi, height, weight, category, gender, sport_id, user_id, hobbyListIntegers);

            return pageToShow;
    }
}
