package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    Search search;
    Footer footer;

    SearchResult searchResult;

    NoSearchPage noSearchPage;

    Navigation navigation;

    PDP pdp;

    PLP plp;
    StoreLocator storeLocator;
    Header header;
    ContactUs contactUs;
    Newsletters newsletters;
    HomePage homePage;
    PDPPage pdpPage;
    PcidPage pcid;
    Cart cart;
    Checkout checkout;
    Auth auth;
    cartPage cart_Pages;
    MyAccount myAccount;
    PCOptimumPoints pcOptimumPoints;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public Search getSearch(){
        search=new Search(driver);
        return search;
    }

    public Footer getFooter(){
        footer=new Footer(driver);
        return footer;
    }

    public SearchResult getSearchResult() {
        searchResult=new SearchResult(driver);
        return searchResult;
    }

    public NoSearchPage getNoSearchPage(){
        noSearchPage=new NoSearchPage(driver);
        return noSearchPage;
    }

    public PDP getPdpPage(){
        pdp=new PDP(driver);
        return pdp;
    }

    public Navigation getNavigation(){
        navigation=new Navigation(driver);
        return navigation;
    }

    public PLP getPlp(){
        plp=new PLP(driver);
        return plp;
    }

    public StoreLocator getStore(){
        storeLocator=new StoreLocator(driver);
        return storeLocator;
    }

    public Header getHeader(){
        header=new Header(driver);
        return header;
    }

    public ContactUs getContactUs(){
        contactUs=new ContactUs(driver);
        return contactUs;
    }

    public Newsletters getNewsletters(){
        newsletters=new Newsletters(driver);
        return newsletters;
    }
    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public PDPPage getPDP() {
        pdpPage = new PDPPage(driver);
        return pdpPage;
    }

    public PcidPage getPcid() {
        pcid = new PcidPage(driver);
        return pcid;
    }
    public Cart getCart(){
        cart=new Cart(driver);
        return cart;
    }

    public Checkout getCheckout(){
        checkout=new Checkout(driver);
        return checkout;
    }

    public Auth getAuth(){
        auth=new Auth(driver);
        return auth;
    }
    public cartPage getCartPage(){
        cart_Pages = new cartPage(driver);
        return cart_Pages;
    }
    public MyAccount getMyAccount() {
        myAccount = new MyAccount(driver);
        return myAccount;
    }

    public PCOptimumPoints getMypcOptimumPoints(){
        pcOptimumPoints=new PCOptimumPoints(driver);
        return pcOptimumPoints;
    }

}
