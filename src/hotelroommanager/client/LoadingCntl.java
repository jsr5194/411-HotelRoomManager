package hotelroommanager.client;


public class LoadingCntl
{
	LoadingUI loadingUI;

	public LoadingCntl(){
		showLoadingUI();
	}

	public void showLoadingUI(){
		if (this.loadingUI == null){
			this.loadingUI = new LoadingUI(this);
		}else{
			this.loadingUI.setVisible(true);
		}
	}

	public void closeLoadingUI(){
		this.loadingUI.setVisible(false);
	}
}