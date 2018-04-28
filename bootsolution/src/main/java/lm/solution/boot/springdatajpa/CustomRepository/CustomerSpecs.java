//package lm.solution.boot.springdatajpa.CustomRepository;
//
//import org.hibernate.type.EntityType;
//import org.springframework.data.jpa.domain.Specification;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerSpecs {
//
//    public static <T> Specification<T> byAuto(
//            final EntityManager entityManager,
//            final T example) {
//
//        final Class<T> type = (Class<T>) example.getClass();
//
//        return new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//                List<Predicate> predicates=new ArrayList<>();
//
//                EntityType<T> entity =entityManager.getMetamodel().entity(type)
//
//
//
//            }
//        };
//
//    }
//
//}
