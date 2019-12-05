package com.example.dealershipfinder;

public class Dealership {
    private String dealershipName;
    private String dealershipURL;

    private void setDealershipInfo(Integer dealerMake){
        switch (dealerMake){
                case 0: //audi
                    dealershipName="Audi";
                    dealershipURL="https://www.audiflatirons.com";
                    break;
                case 1: //bmw
                    dealershipName="BMW";
                    dealershipURL="http://www.gebhardtbmw.com";
                    break;
                case 2: //lexus
                    dealershipName="Lexus";
                    dealershipURL="https://www.stevinsonlexusoflakewood.com";
                    break;
                case 3: //porsche
                    dealershipName="Porsche";
                    dealershipURL="http://www.stevinson.porschedealer.com";
                    break;
                case 4: //mercedes
                    dealershipName="Mercedes-Benz";
                    dealershipURL="http://www.mbwestminster.com";
                    break;
                default:
                    dealershipName="none";
                    dealershipURL="https://www.google.com/search?q=boulder+car+dealerships&rlz=1C5CHFA_enUS779US779&oq=boulder+car+dealer&aqs=chrome.0.0j69i57j0l5j69i61.4315j0j7&sourceid=chrome&ie=UTF-8";
        }
    }

    public String getDealershipName(){
        return dealershipName;
    }

    public String getDealershipURL(){
        return dealershipURL;
    }

    public void setDealershipName(Integer dealerMake){
        setDealershipInfo(dealerMake);
    }

    public void setDealershipURL(Integer dealerMake){
        setDealershipInfo(dealerMake);
    }


}
