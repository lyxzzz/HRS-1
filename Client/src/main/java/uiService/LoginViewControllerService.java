package uiService;

import UserView.LogView;
import common.UserType;

public interface LoginViewControllerService {
         public void updatemodel(String str);
         public void setView(LogView view);
         public boolean login(String logid,String password,String type);
         public boolean register();
         public boolean find();
         public void error();
		public void updateRegisterButton(String selected);
}
