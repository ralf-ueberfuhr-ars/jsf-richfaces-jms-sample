package de.samples.javaee.richfaces.jms.sample.boundary.jsf;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TwoDateFieldsValidator {

  private HtmlInputText startDateComponent;

  @SuppressWarnings("unused")
  public void validate(FacesContext ctx, UIComponent endDateComponent, Object value) {
    LocalDate startDate = (LocalDate) startDateComponent.getLocalValue();
    LocalDate endDate = (LocalDate) value;
    if (endDate.isBefore(startDate)) {
      throw new ValidatorException(
        new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "Date value is too low.",
          "The end date must be equal or later than " + startDate
        )
      );
    }
  }

}
