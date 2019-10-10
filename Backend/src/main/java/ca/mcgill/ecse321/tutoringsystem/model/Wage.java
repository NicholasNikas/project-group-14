package ca.mcgill.ecse321.tutoringsystem.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Wage{
   private Tutor tutor;
   
   @ManyToOne(optional=false)
   public Tutor getTutor() {
      return this.tutor;
   }
   
   public void setTutor(Tutor tutor) {
      this.tutor = tutor;
   }
   
   private Course course;
   
   @ManyToOne(optional=false)
   public Course getCourse() {
      return this.course;
   }
   
   public void setCourse(Course course) {
      this.course = course;
   }
   
   private Integer wage;

public void setWage(Integer value) {
    this.wage = value;
}
public Integer getWage() {
    return this.wage;
}

public static int nextId = 1;
private Integer wageId;

public void setWageId(Integer value) {
    this.wageId = value;
}
@Id
public Integer getWageId() {
    return this.wageId;
}
}
