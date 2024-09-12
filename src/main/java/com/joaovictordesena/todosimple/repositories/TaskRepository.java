package com.joaovictordesena.todosimple.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


import com.joaovictordesena.todosimple.models.Task;
import com.joaovictordesena.todosimple.models.projection.TaskProjection;

@Repository

public interface TaskRepository extends JpaRepository<Task, Long>{


    
    // o _ na frente do user é para explicar que queremos o Id do user
    List<TaskProjection> findByUser_Id(Long id);

    //@Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
    //List<Task> findByUserId(@Param("id") Long id)
      
   

}
