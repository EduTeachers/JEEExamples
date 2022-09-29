package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserBean {

    private int favouriteNumber;

    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    public void setFavouriteNumber(int favouriteNumber) {
        this.favouriteNumber = favouriteNumber;
    }

    public String getUserName() {
        return "samuel.kodytek";
    }

    public String[] getFriends() {
        return new String[]{"Martin", "Pavel", "Josef", "Anna"};
    }



}
