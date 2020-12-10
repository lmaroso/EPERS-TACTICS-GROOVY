package epers.tactics

import grails.gorm.services.Service

@Service(Aventurero)
interface AventureroService {

    Aventurero get(Serializable id)

    List<Aventurero> list(Map args)

    Long count()

    void delete(Serializable id)

    Aventurero save(Aventurero aventurero)

}