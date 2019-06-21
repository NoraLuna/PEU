/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import conexiones.Preguntas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ras_05
 */
@Stateless
public class PreguntasFacade extends AbstractFacade<Preguntas> {

    @PersistenceContext(unitName = "PEUPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntasFacade() {
        super(Preguntas.class);
    }
    
}
