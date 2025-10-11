package at.spengergasse.diplo3entities.repository;

import at.spengergasse.diplo3entities.enums.FrontendArea;
import at.spengergasse.diplo3entities.model.TextSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextSectionRepository extends JpaRepository<TextSection, Long> {
    boolean existsByFrontendAreaAndIsTitleTrue(FrontendArea area);
    List<TextSection> findAllByFrontendAreaOrderByPositionAsc(FrontendArea area);
}