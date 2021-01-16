package com.example.applicationstore;

public class CardData {
    private String mainTitle;
    private String viceTitle;
    private SoftCard softCardOne;
    private SoftCard softCardTwo;
    private SoftCard softCardThree;
    private SoftCard softCardFour;

    public CardData(String mainTitle, String viceTitle, SoftCard softCardOne, SoftCard softCardTwo, SoftCard softCardThree, SoftCard softCardFour) {
        this.mainTitle = mainTitle;
        this.viceTitle = viceTitle;
        this.softCardOne = softCardOne;
        this.softCardTwo = softCardTwo;
        this.softCardThree = softCardThree;
        this.softCardFour = softCardFour;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getViceTitle() {
        return viceTitle;
    }

    public int getSoftCardImageOne() {
        return softCardOne.getImageID();
    }

    public int getSoftCardImageTwo() {
        return softCardTwo.getImageID();
    }

    public int getSoftCardImageThree() {
        return softCardThree.getImageID();
    }

    public int getSoftCardImageFour() {
        return softCardFour.getImageID();
    }


    public String getSoftCardNameOne() {
        return softCardOne.getSoftName();
    }

    public String getSoftCardNameTwo() {
        return softCardTwo.getSoftName();
    }

    public String getSoftCardNameThree() {
        return softCardThree.getSoftName();
    }

    public String getSoftCardNameFour() {
        return softCardFour.getSoftName();
    }


    public String getSoftCardInstallDataOne() {
        return softCardOne.getInstallData();
    }

    public String getSoftCardInstallDataTwo() {
        return softCardTwo.getInstallData();
    }

    public String getSoftCardInstallDataThree() {
        return softCardThree.getInstallData();
    }

    public String getSoftCardInstallDataFour() {
        return softCardFour.getInstallData();
    }

}

class SoftCard {
    private int imageID;
    private String softName;
    private String installData;

    public void setData(int imageID, String softName, String installdData) {
        this.imageID = imageID;
        this.softName = softName;
        this.installData = installdData;
    }

    public int getImageID() {
        return imageID;
    }

    public String getSoftName() {
        return softName;
    }

    public String getInstallData() {
        return installData;
    }
}
