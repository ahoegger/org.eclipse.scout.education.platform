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

import javax.annotation.PostConstruct;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.CreateImmediately;
import org.eclipse.scout.rt.testing.platform.runner.PlatformTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(PlatformTestRunner.class)
public class T_008_CreateImmediatelyBean {

  public static boolean BEAN_INITIALIZED = false;

  @Test
  public void test() {
    Assert.assertTrue(BEAN_INITIALIZED);
  }

  @ApplicationScoped
  public static interface T_008_BeanInterface {

  }

  @CreateImmediately
  public static class T_008_Bean1 implements T_008_BeanInterface {

    @PostConstruct
    protected void init() {
      BEAN_INITIALIZED = true;
    }

  }

}
