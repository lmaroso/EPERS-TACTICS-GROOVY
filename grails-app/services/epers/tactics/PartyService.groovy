package epers.tactics

import grails.gorm.services.Service

@Service(Party)
interface PartyService {

    Party get(Serializable id)

    List<Party> list(Map args)

    Long count()

    void delete(Serializable id)

    Party save(Party party)

}