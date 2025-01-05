package com.learn.QuizApp.controller;

import com.learn.QuizApp.modal.Question;
import com.learn.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
      return  questionService.getQuestionByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }

    @DeleteMapping("{id}")
    public String deleteQuestionById(@PathVariable Long id){

       return questionService.deleteQuestionById(id);

    }

    @PutMapping("{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

}
