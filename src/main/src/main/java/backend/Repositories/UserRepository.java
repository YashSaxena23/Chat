package backend.Repositories;

import backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = " select * from user where mobile = :mobile and isActive = 1",nativeQuery = true)
    User getUserByMobile(@Param("mobile") String mobile);

    @Query(value = " select * from user where email = :mobile and isActive = 1",nativeQuery = true)
    User getUserByEmail(@Param("mobile") String mobile);
}
