//package web.commands;
//
//import business.exceptions.UserException;
//import business.services.CupcakeFacade;
//import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class ManageCupcakeCommand extends CommandProtectedPage {
//
//    CupcakeFacade cupcakeFacade;
//
//    public ManageCupcakeCommand(String pageToShow, String role)
//    {
//        super(pageToShow, role);
//        this.cupcakeFacade = new CupcakeFacade(database);
//    }
//
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
//    {
//        // delete, edit, update
//        String deleteId = request.getParameter("delete");
//        String editId = request.getParameter("edit");
//
//        if (deleteId != null)
//        {
//            int rowsAffected = bmiFacade.deleteSport(Integer.parseInt(deleteId));
//            if (rowsAffected > 0)
//            {
//                request.getServletContext().setAttribute("sportList", bmiFacade.getAllSports());
//            }
//            else
//            {
//                request.setAttribute("error", "Du kan ikke fjerne denne sportsgren, da den er valgt af andre brugere!!");
//            }
//
//            if(editId != null)
//            {
//                return "editsport";
//            }
//
//        }
//        return pageToShow;
//    }
//}