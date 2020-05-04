package com.oozinoz.visualization;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2001 Steven J. Metsker.
 *
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose,
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

/**
 * This class supports a visualization (a picture) of
 * an Oozinoz factory.
 *
 * @author Steven J. Metsker
 */
public class FactoryModel {

    protected List<MachineImage> machines = new ArrayList<>();

    /**
     * Return true if this model has no machines.
     *
     * @return true if this model has no machines
     */
    public boolean isEmpty() {
        return machines.isEmpty();
    }


    /**
     * Add a (simulated) machineImage to this (simulated) factory.
     *
     * @param machineImage the machineImage to add
     */
    public void addMachine(MachineImage machineImage) {
        machines.add(machineImage);
    }

    /**
     * Create a list of MachineImage clones that record the
     * state of the simulation at this time.
     *
     * @return a list of MachineImage clones that record the
     * state of the simulation at this time.
     */
    public List<MachineImage> createMemento() {

        List<MachineImage> clonedMachineImages = new ArrayList<>();

        for (MachineImage machineImage : machines) {
            clonedMachineImages.add((MachineImage) machineImage.clone());
        }

        return clonedMachineImages;
    }

    /**
     * Return the machines in this factory model.
     *
     * @return the machines in this factory model
     */
    public List<MachineImage> getMachines() {
        return machines;
    }

    /**
     * Reset the state of this simulation to the state recorded
     * in the provided list.
     *
     * @param restorableMachineImageList a list of MachineImage clones
     */
    public void restore(List<MachineImage> restorableMachineImageList) {
        machines = new ArrayList<>();

        for (MachineImage machineImage : restorableMachineImageList) {
            machines.add((MachineImage) machineImage.clone());
        }
    }
}
