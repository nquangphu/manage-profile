package com.nqphu.service;

import com.nqphu.dao.ProfileDAO;
import com.nqphu.model.ProfileModel;

/**
 *
 * @author phu
 */
public class ProfileService {

    private ProfileDAO profileDAO;
    
    public ProfileService() {
        profileDAO = new ProfileDAO();
    }

    public ProfileModel getProfile(int id) {
        return profileDAO.getProfile(id);
    }
    
    public ProfileModel findByUserNameAndPassword (String username, String password) {
        return profileDAO.findByUserNameAndPassword(username, password);
    }
}
