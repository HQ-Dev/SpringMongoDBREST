package hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * SpringBoot 默认连接本地的 mongo 实例。可以通过设置来连接你需要连接的 mongoDB 实例地址
 */


/**
 * 接口，以后可以创建自定义的类实现这个接口来对 Person 对象进行定制化地操作
 *
 * 程序在运行时，会自动创建这个接口的一个实现。然后它会通过注解 @RepositoryRestResource 指挥 Spring MVC 创建 /people 这样的 RESTful 节点
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {

    /**
     * 定义了一个通过 lastName 来获取 Person 列表的方法
     * @param name
     * @return
     */
    List<Person> findByLastName(@Param("name") String name);

}
