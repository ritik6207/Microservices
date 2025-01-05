package com.learn.QuizApp.service;

import com.learn.QuizApp.dao.QuestionDao;
import com.learn.QuizApp.modal.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion() {
        return questionDao.findAll();
    }


    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success!";
    }


    public String deleteQuestionById(Long id) {
      questionDao.deleteById(id);
      return "Question deleted successfully.";
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        updatedQuestion.setId(id);
        return questionDao.save(updatedQuestion);
    }
}
