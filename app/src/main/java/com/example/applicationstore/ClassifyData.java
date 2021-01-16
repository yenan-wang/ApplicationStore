package com.example.applicationstore;

public class ClassifyData {
    private int imageID;

    private String buttonOneText;
    private String buttonTwoText;
    private String buttonThreeText;
    private String buttonFourText;
    private String buttonFiveText;
    private String buttonSixText;

    private int buttonOneVisibility;
    private int buttonTwoVisibility;
    private int buttonThreeVisibility;
    private int buttonFourVisibility;
    private int buttonFiveVisibility;
    private int buttonSixVisibility;

    public ClassifyData(int imageID,
                            String buttonOneText, int buttonOneVisibility,
                            String buttonTwoText, int buttonTwoVisibility,
                            String buttonThreeText, int buttonThreeVisibility,
                            String buttonFourText, int buttonFourVisibility,
                            String buttonFiveText, int buttonFiveVisibility,
                            String buttonSixText, int buttonSixVisibility) {
        this.imageID = imageID;
        this.buttonOneText = buttonOneText;
        this.buttonOneVisibility = buttonOneVisibility;
        this.buttonTwoText = buttonTwoText;
        this.buttonTwoVisibility = buttonTwoVisibility;
        this.buttonThreeText = buttonThreeText;
        this.buttonThreeVisibility = buttonThreeVisibility;
        this.buttonFourText = buttonFourText;
        this.buttonFourVisibility = buttonFourVisibility;
        this.buttonFiveText = buttonFiveText;
        this.buttonFiveVisibility = buttonFiveVisibility;
        this.buttonSixText = buttonSixText;
        this.buttonSixVisibility = buttonSixVisibility;


    }

    public int getImageID() {
        return imageID;
    }

    public String getButtonOneText() {
        return buttonOneText;
    }

    public String getButtonTwoText() {
        return buttonTwoText;
    }

    public String getButtonThreeText() {
        return buttonThreeText;
    }

    public String getButtonFourText() {
        return buttonFourText;
    }

    public String getButtonFiveText() {
        return buttonFiveText;
    }

    public String getButtonSixText() {
        return buttonSixText;
    }

    public int getButtonOneVisibility() {
        return buttonOneVisibility;
    }

    public int getButtonTwoVisibility() {
        return buttonTwoVisibility;
    }

    public int getButtonThreeVisibility() {
        return buttonThreeVisibility;
    }

    public int getButtonFourVisibility() {
        return buttonFourVisibility;
    }

    public int getButtonFiveVisibility() {
        return buttonFiveVisibility;
    }

    public int getButtonSixVisibility() {
        return buttonSixVisibility;
    }
}
