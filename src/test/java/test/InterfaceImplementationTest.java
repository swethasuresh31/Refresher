package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.DualRole;
import main.PrimeDealSaleItem;
import main.DualRole.IParent;
import main.DualRole.IWorker;
import main.DualRole.WorkingParent;

public class InterfaceImplementationTest {

	@Test
	public void testParentInterface() {
		WorkingParent mom = new DualRole().new WorkingParent("mom", 2);
		assertTrue(mom instanceof IParent);
		
		//mom as a parent
		IParent parent = mom;
		parent.feedBaby();
		assertEquals(1, mom.getEnergyLevel());
	}

	@Test
	public void testWorkerInterface() {
		WorkingParent mom = new DualRole().new WorkingParent("mom", 2);
		assertTrue(mom instanceof IWorker);

		//mom as a worker
		IWorker worker = mom;
		worker.accomplishTaskAtWork();
		assertEquals(1, mom.getEnergyLevel());
	}

	@Test
	public void testMultiInterface() {
		WorkingParent mom = new DualRole().new WorkingParent("mom", 2);
		assertTrue(mom instanceof IParent);
		assertTrue(mom instanceof IWorker);
		
		//mom as a worker and parent
		IParent parent = mom;
		IWorker worker = mom;
		parent.feedBaby();
		assertEquals(1, mom.getEnergyLevel());
		worker.commuteToWork();
		assertEquals(0, mom.getEnergyLevel());
		worker.accomplishTaskAtWork();
		assertEquals(0, mom.getEnergyLevel());
		mom.eatFood();
		assertEquals(1, mom.getEnergyLevel());
		parent.takeBabyForWalk();
		assertEquals(0, mom.getEnergyLevel());
	}
}