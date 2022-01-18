package it.corsospringweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WelcomeRestController {


    @ResponseBody
    @RequestMapping("/welcome")
    public String welcome() {
        return "{message:\"welcome\"}";
    }


    @RequestMapping("/testJSP")
    public String testJSP(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/goodbye")
    public String goodbye() {
        return "{message:\"goodbye\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/goodbye2", method = RequestMethod.GET, params = {"nome=MyApp", "version=1.0"})
    public String welcomeParams() {
        return "{message:\"goodbye with params\"}";
    }

    @ResponseBody
    @RequestMapping(value = "/goodbyeFunzionante", method = RequestMethod.GET, params = {"nome=MyApp", "version=1.0"})
    public String welcomeParamsFunzionante() {
        System.out.println("ciao");
        return "{message:\"goodbye with params\"}";
    }

    @ResponseBody
    @GetMapping("/saluto")
    public String saluto(HttpServletRequest request) {
        if ((request.getParameter("name") != null) && !(request.getParameter("name").trim().equals(""))) {
            return "Ciao " + request.getParameter("name");
        } else {
            return "Ciao, non ti conosco!";
        }
    }

    // http://corsospringweb/saluto2?name=Federico  --> "Ciao Federico"
    // http://corsospringweb/saluto2?name=          --> "Ciao #STRINGA_VUOTA"
    // http://corsospringweb/saluto2                --> "Ciao null"
    @ResponseBody
    @GetMapping("/saluto2")
    public String saluto2(HttpSession session) {
        if (session.getAttribute("name") == null)
            session.setAttribute("name", "Federico");

        return "Ciao " + session.getAttribute("name").toString();
    }

    // http://corsospringweb/saluto3?name=Federico
    @ResponseBody
    @GetMapping("/saluto3")
    public String saluto3(@RequestParam("name") String nome) {
        return "Ciao " + nome;
    }


    //@RequestHeader permette di accere ai dati dell'header (ispezione tab header) e copiando il campo, lo si può mappare. Stessa cosa vale
    //per l'annotation @CookieValue, permette di accedere a tali dati, in questo caso, la lingua del browser.
    @ResponseBody
    @GetMapping("/saluto4")
    public String saluto4(@RequestHeader("User-Agent") String userAgent, @CookieValue("GUEST_LANGUAGE_ID") String languageID) {
        return "Il tuo browser è " + userAgent + " --- la lingua invece è " + languageID;
    }


    //Se non è null, lo saluta, altrimenti si presenta. Il messaggio viene gestito attraverso il forward con una chiamata al metodo2 (qui sotto)

    // http://localhost:8080/corsospringweb_war/rest/jumpToMethod2?name=Federico  --> "Ciao Federico"
    // http://localhost:8080/corsospringweb_war/rest/jumpToMethod2?name=          --> "Ciao #STRINGA_VUOTA"
    // http://localhost:8080/corsospringweb_war/rest/jumpToMethod2                --> "Ciao null"

    @GetMapping(value = "/1")
    public String metodo1(HttpServletRequest request) {
        if ((request.getParameter("nome") != null) && !(request.getParameter("nome").trim().equals("")))
            request.setAttribute("messaggio", "Ciao " + request.getParameter("nome"));
         else
            request.setAttribute("messaggio", "Hi, nice to meet you!");

        return "forward:/2";
    }

    @ResponseBody
    @GetMapping(value = "/2")
    public String metodo2(@RequestAttribute("messaggio") String saluto) {
        return saluto;
    }
}
