package ch.sebooom.springdddspi.repository;


import ch.sebooom.springddddomain.model.demande.Demande;
import ch.sebooom.springddddomain.model.demande.DemandeId;
import ch.sebooom.springddddomain.model.person.Personnne;
import ch.sebooom.springddddomain.port.repository.DemandeRepository;
import lombok.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Profile("memorydb")
public class DemandeInMemoryRepository implements DemandeRepository {

    private Map<DemandeId, Demande> datas = new HashMap<>();


    @Override
    public Optional<Demande> getDemandeByIdentity(DemandeId demandeId) {
        sleep();

        if(datas.containsKey(demandeId)) {
            return Optional.of(datas.get(demandeId));
        }else{
            return Optional.empty();
        }

    }

    private void sleep () {
        try {
            Thread.sleep(125);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Demande update(Demande demande) {
        sleep();
        if(datas.containsKey(demande.getId())) {
            datas.put(demande.getId(),demande);
            return demande;
        }else{
            throw new InMemoryDatasException(String.format("No Demande exist with this key:{%s}",demande.getId()) );
        }
    }

    @Override
    public List<Demande> getAllDemande() {
        sleep();
        return datas.values().stream().collect(Collectors.toList());
    }



    @Override
    public Demande creerNouvelleDemande(@NonNull DemandeId demandeId, Personnne personnne) {
        sleep();
        if(!datas.containsKey(demandeId)){
            Demande demande = new Demande(demandeId,personnne);
            datas.put(demandeId,demande);

            return demande;
        }else{
            throw new InMemoryDatasException(String.format("Demande already exist with this key:{%s}",demandeId) );
        }
    }
}
