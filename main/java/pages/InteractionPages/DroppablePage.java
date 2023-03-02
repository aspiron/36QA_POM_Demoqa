package pages.InteractionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.Collection;

public class DroppablePage extends PageBase {
    public DroppablePage(WebDriver dr) {
        super(dr);
    }


    @FindBy(id = "draggable")
    WebElement draggable;

    @FindBy(id = "droppable")
    WebElement droppable;

    public DroppablePage testDroppableHere() {
        Actions actions = new Actions(dr);
        wait(1000);
        actions.dragAndDrop(draggable, droppable).perform();
        return this;
    }

    public String getDroppedResult() {
        return droppable.getText();
    }

    public DroppablePage testDroppableByOffset() {
        Actions actions = new Actions(dr);

        int xOffsetDraggable = draggable.getLocation().getX();
        int yOffsetDraggable = draggable.getLocation().getY();

        int xOffsetDroppable = droppable.getLocation().getX();
        int yOffsetDroppable = droppable.getLocation().getY();

        int xOffset = (xOffsetDroppable - xOffsetDraggable) + 30;
        int yOffset = (yOffsetDroppable - yOffsetDraggable) + 30;

        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
        wait(1000);

        return this;
    }
}
