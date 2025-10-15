package at.spengergasse.diplo3entities.model;

import at.spengergasse.diplo3entities.enums.FrontendArea;
import at.spengergasse.diplo3entities.myValueObjects.Position;
import at.spengergasse.diplo3entities.myValueObjects.Text;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(
        name = "text_section",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"frontend_area", "position"})
        }
)
@Getter
@ToString
public class TextSection extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "frontend_area", nullable = false)
    @Embedded
    private FrontendArea frontendArea;

    @Column(name = "text", unique = false, nullable = false, length = 1000)
    @NotBlank @Size(max = 1000)
    private Text text;

    @Column(name = "isTitle", nullable = false)
    private boolean isTitle;

    @Min(1)
    @Max(10)
    @Column(name = "position", nullable = false)
    @Embedded
    private Position position;

    public TextSection() {
        super();
    }

    public TextSection(FrontendArea frontendArea, Text text, boolean isTitle, Position position) {
        super();
        this.frontendArea = frontendArea;
        this.text = text;
        this.isTitle = isTitle;
        this.position = position;
    }
}