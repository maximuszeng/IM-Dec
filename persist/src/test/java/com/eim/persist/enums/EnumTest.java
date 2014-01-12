/**
 * 
 */
package com.eim.persist.enums;

import org.springframework.util.Assert;

/**
 * @author jacky.yang
 * 
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppType[] values = AppType.values();

		for (AppType at : values) {
			Assert.isTrue(at.ordinal() == at.getId());
		}

		ConcurrentServiceMode[] values1 = ConcurrentServiceMode.values();

		for (ConcurrentServiceMode at : values1) {
			Assert.isTrue(at.ordinal() == at.getId());
		}

		ContentType[] values2 = ContentType.values();

		for (ContentType at : values2) {
			Assert.isTrue(at.ordinal() == at.getId());
		}

		DialogDirection[] values3 = DialogDirection.values();

		for (DialogDirection at : values3) {
			Assert.isTrue(at.ordinal() == at.getId());
		}

		UserType[] values4 = UserType.values();

		for (UserType at : values4) {
			Assert.isTrue(at.ordinal() == at.getId());
		}
		System.out.println("finished");
	}

}
