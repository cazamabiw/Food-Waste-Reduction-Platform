package com.fwrp.managers;

import com.fwrp.datatier.dao.FoodItemDao;
import com.fwrp.datatier.dao.FoodItemDaoImpl;
import com.fwrp.datatier.dao.FoodStatusDao;
import com.fwrp.datatier.dao.FoodStatusDaolmpl;
import com.fwrp.models.FoodItem;
import com.fwrp.models.FoodStatus;
import java.util.List;

public class FoodManager {
    private final FoodItemDao foodItemDao;
    private final FoodStatusDao foodStatusDao;

    public FoodManager() {

        foodItemDao = new FoodItemDaoImpl();
        foodStatusDao = new FoodStatusDaolmpl();

    }

    //getfooditem
    //getfoodstatus
    public List<FoodItem> getFoodItems() {
        return foodItemDao.getAll();
    }
   public FoodItem getFoodItem(int foodItemId) {
        return foodItemDao.get(foodItemId);
    }
    public List<FoodStatus> getFoodStatuses() {
        return foodStatusDao.getAll();
    }

}
