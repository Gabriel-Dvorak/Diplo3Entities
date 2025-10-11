package at.spengergasse.diplo3entities.service;

import at.spengergasse.diplo3entities.enums.FrontendArea;
import at.spengergasse.diplo3entities.model.TextSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextSectionService {

    private final TextSectionRepository repository;

    @Autowired
    public TextSectionService(TextSectionRepository repository) {
        this.repository = repository;
    }

    public void addTextSection(TextSection section) {
        if (section.isTitle()) {
            boolean exists = repository.existsByFrontendAreaAndIsTitleTrue(section.getFrontendArea());
            if (exists) {
                throw new IllegalStateException("Bereich " + section.getFrontendArea() + " hat bereits einen Titel!");
            }
        }
        repository.save(section);
    }

    public interface TextSectionRepository extends JpaRepository<TextSection, Long> {
        boolean existsByFrontendAreaAndIsTitleTrue(FrontendArea area);
        List<TextSection> findAllByFrontendAreaOrderByPositionAsc(FrontendArea area);
    }
}