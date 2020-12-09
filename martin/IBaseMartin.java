package martin;

public interface IBaseMartin {
	void enemyEnter(Enemy e) throws InterruptedException;
	void enemyExit(Enemy e);
	void martinLeave();
	void martinEnter() throws InterruptedException;
	void martinExit();
}