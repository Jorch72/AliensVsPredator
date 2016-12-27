package org.avp.util;

/**
 * Provides the ability to prevent certain entities from being infected by parasites 
 * or the ability to prevent said entities from being infected at the current time.
 */
public interface IParasiticHost
{
    public boolean canParasiteAttach();
    
    public boolean canHostParasite();
}