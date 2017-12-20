package ch.sebooom.springdddapi.web;

import ch.sebooom.springdddapplication.service.DemandeService;
import ch.sebooom.springddddomain.model.demande.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    DemandeService demandeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Demande> listeDemande () {
        return demandeService.listerDemande();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Demande creerDemande () {
        return null;
    }


}
