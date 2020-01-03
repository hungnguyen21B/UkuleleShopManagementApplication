package Account;

public interface IAccount {
	public abstract boolean checkLogin(String username,String password);
	public abstract boolean checkRegister(String username,String password1,String password2);
}
