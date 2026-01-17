package com.example.personalprofile.services;

import com.example.personalprofile.models.Skill;
import com.example.personalprofile.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Long id, Skill skillDetails) {
        return skillRepository.findById(id).map(skill -> {
            skill.setName(skillDetails.getName());
            skill.setCategory(skillDetails.getCategory());
            skill.setLevel(skillDetails.getLevel());
            return skillRepository.save(skill);
        }).orElseThrow(() -> new RuntimeException("Skill not found with id " + id));
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
