package ca.mcgill.ecse321.tutoringsystem.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ca.mcgill.ecse321.tutoringsystem.dao.WageRepository;
import ca.mcgill.ecse321.tutoringsystem.model.Course;
import ca.mcgill.ecse321.tutoringsystem.model.Tutor;
import ca.mcgill.ecse321.tutoringsystem.model.Wage;

@Service
public class WageService {
  @Autowired
  WageRepository wageRepository;
  
  @Transactional
  public Wage createWage(Tutor tutor, Course course, Integer wage) {
      if (tutor == null) {
          throw new IllegalArgumentException("A tutor needs to be specified!");
      }
      if (course == null) {
          throw new IllegalArgumentException("Course cannot be empty!");
      }
      if (wage == null || wage <= 0) {
          throw new IllegalArgumentException("Wage cannot be negative or zero!");
      }
      Wage w = new Wage();
      w.setTutor(tutor);
      w.setWage(wage);
      w.setCourse(course);
      wageRepository.save(w);
      return w;
  }

  @Transactional
  public Wage getWage(Integer wageId) {
      Wage w = wageRepository.findWageByWageId(wageId);
      return w;
  }
  
  @Transactional
  public Wage updateWage(Integer wageId, Integer wage) {
	  Wage w = wageRepository.findWageByWageId(wageId);
	  if (w == null) {
          throw new NullPointerException("No Wage by this id.");
      }
	  w.setWage(wage);
	  wageRepository.save(w);
	  return w;
  }

  @Transactional
  public List<Wage> getAllWages() {
      return toList(wageRepository.findAll());
  }
  
  @Transactional
  public List<Wage> getWageByTutor(Tutor tutor) {
      return toList(wageRepository.findWageByTutor(tutor));
  }
  
  @Transactional
  public List<Wage> getWageByCourse(Course course) {
	    if (course == null) {
	        throw new IllegalArgumentException("Course cannot be empty!");
	      }
	  return wageRepository.findWageByCourse(course);
  }
  
  @Transactional
  public boolean deleteWage(Integer id) {
      Wage w = wageRepository.findWageByWageId(id);
      if (w == null) {
          throw new NullPointerException("No Wage by this id.");
      }
      wageRepository.delete(w);
      return true;
  }
  
  private <T> List<T> toList(Iterable<T> iterable) {
    List<T> resultList = new ArrayList<T>();
    for (T t : iterable) {
      resultList.add(t);
    }
    return resultList;
  }
}
