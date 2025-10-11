package at.spengergasse.diplo3entities.modelBean;

import at.spengergasse.diplo3entities.enums.FrontendArea;
import at.spengergasse.diplo3entities.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(
        name = "text_section_bean",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"frontend_area", "position"})
        }
)
@Getter
@ToString
@NoArgsConstructor
public class TextSectionBean extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "frontend_area", nullable = false)
    private FrontendArea frontendArea;

    @Column(name = "text", nullable = false, length = 1000)
    @NotBlank(message = "Text cannot be blank")
    @Size(min = 1, max = 1000, message = "Text must be between 1 and 1000 characters")
    private String text;

    @Column(name = "is_title", nullable = false)
    private boolean isTitle;

    @Column(name = "position", nullable = false)
    @Min(value = 1, message = "Position must be at least 1")
    @Max(value = 10, message = "Position must be at most 10")
    private int position;

    public TextSectionBean(FrontendArea frontendArea, String text, boolean isTitle, int position) {
        super();
        this.frontendArea = frontendArea;
        this.text = text;
        this.isTitle = isTitle;
        this.position = position;
    }
}