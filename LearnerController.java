package com.project.springstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnerController {

  ArrayList<Learner> learners = new ArrayList<>(Arrays.asList(new Learner(1,"Raj", "Algo"),
  new Learner(2,"Pavan", "C++"),
  new Learner(3,"Yogi", "Python"),
  new Learner(4,"Punit", "HTML")
  ));

@RequestMapping("/learners") 
List<Learner> getAllLearners() {
  return learners;
 }

@RequestMapping("/learners/{id}")
Learner getLearnerById(@PathVariable int id) {
  return learners.stream().filter(ref -> ref.id().equals(id)).findFirst().get();
 }

@PostMapping("/learners")
void addLearner(@RequestBody Learner theLearner) {
  learners.add(theLearner);
 }

}
