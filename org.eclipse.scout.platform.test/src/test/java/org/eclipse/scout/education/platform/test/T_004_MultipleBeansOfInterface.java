/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.education.platform.test;

import org.eclipse.scout.commons.Assertions.AssertionException;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_004_MultipleBeansOfInterface {

  @Test(expected = AssertionException.class)
  public void test() {
    BEANS.get(T_004_BeanInterface.class);
  }

  @ApplicationScoped
  public static interface T_004_BeanInterface {

  }

  public static class T_004_Bean1 implements T_004_BeanInterface {

  }

  public static class T_004_Bean2 implements T_004_BeanInterface {

  }

}
