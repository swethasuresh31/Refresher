package main;

public class DualRole {

	public interface IParent {
		public void feedBaby();

		public void takeBabyForWalk();
	}

	public interface IWorker {
		public void commuteToWork();

		public void accomplishTaskAtWork();
	}

	public class WorkingParent implements IParent, IWorker {

		private int energyLevel;
		private String name;

		public WorkingParent(String name, int energyLevel) {
			this.name = name;
			this.energyLevel = energyLevel;
		}

		public int getEnergyLevel() {
			return energyLevel;
		}

		private boolean hasEnergy() {
			if (energyLevel >= 1) {
				return true;
			}
			System.out.println(name + " is burned out! " + name + " needs to eat food");
			return false;
		}

		private void doTask(String message) {
			if (hasEnergy()) {
				System.out.println(name + " is " + message);
				energyLevel--;
			}
		}

		public void commuteToWork() {
			doTask("commuting to work!");
		}

		public void accomplishTaskAtWork() {
			doTask("accomplishing tasks at work!");
		}

		public void feedBaby() {
			doTask("Feeding the baby!");
		}

		public void takeBabyForWalk() {
			doTask("Taking baby for a walk!");
		}

		public void eatFood() {
			System.out.println(name + "has eaten food!");
			energyLevel++;
		}

	}

	public static void main(String[] args) {
		WorkingParent mom = new DualRole().new WorkingParent("mom", 2);
		IParent parent = mom;
		IWorker worker = mom;
		parent.feedBaby();
		worker.commuteToWork();
		worker.accomplishTaskAtWork();
		mom.eatFood();
		parent.takeBabyForWalk();
	}
}
