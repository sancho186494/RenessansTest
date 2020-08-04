package managers;


import pages.StartPage;
import pages.DepositPage;

public class PageManager {

    private static PageManager pageManager;

    private StartPage startPage;
    private DepositPage contributionPage;

    private PageManager(){}

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public DepositPage getDepositPage() {
        if (contributionPage == null) {
            contributionPage = new DepositPage();
        }
        return contributionPage;
    }
}
