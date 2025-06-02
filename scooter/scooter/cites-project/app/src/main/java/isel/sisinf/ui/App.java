/*
MIT License

Copyright (c) 2025, Nuno Datia, Matilde Pato, ISEL

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package isel.sisinf.ui;

import isel.sisinf.jpa.ServicesData.DataDock;
import isel.sisinf.jpa.ServicesData.DataTravel;
import isel.sisinf.jpa.jpaContext;
import isel.sisinf.jpa.repositorys.RepositoryRider;
import isel.sisinf.jpa.repositorys.RepositoryStation;
import isel.sisinf.model.Rider;
import isel.sisinf.model.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import isel.sisinf.jpa.ServicesData.DataRider;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * Didactic material to support
 * to the curricular unit of
 * Introduction to Information Systems
 *
 * The examples may not be complete and/or totally correct.
 * They are made available for teaching and learning purposes and
 * any inaccuracies are the subject of debate.
 */

interface DbWorker
{
    void doWork();
}
class UI
{
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dal-lab");
    private static final EntityManager em = emf.createEntityManager();
    private static final jpaContext context = new jpaContext(em);

    private enum Option
    {
        // DO NOT CHANGE ANYTHING!
        Unknown,
        Exit,
        createCostumer,
        listCostumer,
        listDocks,
        startTrip,
        parkScooter,
        about
    }
    private static UI __instance = null;

    private HashMap<Option,DbWorker> __dbMethods;

    private UI()
    {
        // DO NOT CHANGE ANYTHING!
        __dbMethods = new HashMap<Option,DbWorker>();
        __dbMethods.put(Option.createCostumer, () -> UI.this.createCostumer());
        __dbMethods.put(Option.listCostumer, () -> UI.this.listCostumer());
        __dbMethods.put(Option.listDocks, () -> UI.this.listDocks());
        __dbMethods.put(Option.startTrip, new DbWorker() {public void doWork() {UI.this.startTrip();}});
        __dbMethods.put(Option.parkScooter, new DbWorker() {public void doWork() {UI.this.parkScooter();}});
        __dbMethods.put(Option.about, new DbWorker() {public void doWork() {UI.this.about();}});
    }

    public static UI getInstance()
    {
        // DO NOT CHANGE ANYTHING!
        if(__instance == null)
        {
            __instance = new UI();
        }
        return __instance;
    }

    private Option DisplayMenu()
    {
        Option option = Option.Unknown;
        Scanner s = new Scanner(System.in); //Scanner closes System.in if you call close(). Don't do it
        try
        {
            // DO NOT CHANGE ANYTHING!
            System.out.println("CITES Manadgement DEMO");
            System.out.println();
            System.out.println("1. Exit");
            System.out.println("2. Create Costumer");
            System.out.println("3. List Existing Costumer");
            System.out.println("4. List Docks");
            System.out.println("5. Start Trip");
            System.out.println("6. Park Scooter");
            System.out.println("7. About");
            System.out.print(">");
            int result = s.nextInt();
            option = Option.values()[result];
        }
        catch(RuntimeException ex)
        {
            //nothing to do.
        }

        return option;

    }
    private static void clearConsole() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        for (int y = 0; y < 25; y++) //console is 80 columns and 25 lines
            System.out.println("\n");
    }

    public void Run() throws Exception
    {
        // DO NOT CHANGE ANYTHING!
        Option userInput;
        do
        {
            clearConsole();
            userInput = DisplayMenu();
            clearConsole();
            try
            {
                __dbMethods.get(userInput).doWork();
                System.in.read();
            }
            catch(NullPointerException ex)
            {
                //Nothing to do. The option was not a valid one. Read another.
            }

        }while(userInput!=Option.Exit);
    }

    /**
    To implement from this point forward.
    -------------------------------------------------------------------------------------
        IMPORTANT:
    --- DO NOT MESS WITH THE CODE ABOVE. YOU JUST HAVE TO IMPLEMENT THE METHODS BELOW ---
    --- Other Methods and properties can be added to support implementation.
    ---- Do that also below                                                         -----
    -------------------------------------------------------------------------------------

    */

    private static final int TAB_SIZE = 24;

    private void createCostumer() {
        try {
            RepositoryRider riderRepo = context.getRepositoryRider();
            Rider newRider = DataRider.createRiderFromInput();
            context.beginTransaction();
            riderRepo.create(newRider);
            context.commitTransaction();
            System.out.println("Rider criado com sucesso: " + newRider.getName());
        } catch (Throwable e) {
            if (context.isTransactionActive()) context.rollbackTransaction();
            System.err.println("Erro ao criar cliente: " + e.getMessage());
        }
    }

    private void listCostumer() {
        RepositoryRider riderRepo = context.getRepositoryRider();
        try {
            Collection<Rider> riders = riderRepo.find("SELECT r FROM Rider r");

            riders.forEach(rider ->
                    System.out.println("Client: " + rider.getName() + ", Type of Card: " + rider.getTypeofcard())
            );

        } catch (Exception e) {
            System.err.println("Error listing customers: " + e.getMessage());
        }
    }

    private void listDocks() {
        RepositoryStation stationRepo = context.getRepositoryStation();
        Map<Station, BigDecimal> occupancyMap = stationRepo.getOccupancy();

        try {
            occupancyMap.forEach((station, occupancy) -> {
                System.out.printf("Dock ID: %d,Occupancy: %.2f%%\n", station.getId(), occupancy);
            });

        } catch (Exception e) {
            System.err.println("Erro ao listar docas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void startTrip() {
        try {
            int[] inputTravel = DataTravel.readTripInput();

            context.beginTransaction();
            context.getRepositoryTravel().startTrip(inputTravel[0], inputTravel[1]);
            context.commitTransaction();
            System.out.println("Viagem iniciada com sucesso!");
        } catch (Throwable e) {
            if (context.isTransactionActive()) context.rollbackTransaction();
            System.err.println("Erro ao iniciar viagem: " + e.getMessage());
        }
    }

    private void parkScooter() {
        try {
            int[] dockAndScooterIds = DataDock.readDockScooterInput();

            context.beginTransaction();
            context.getRepositoryDock().placeScooterInDock(dockAndScooterIds[0], dockAndScooterIds[1]);
            System.out.println("are sleeping");
            Thread.sleep(20000);
            context.commitTransaction();

            System.out.println("Scooter colocada com sucesso na doca " + dockAndScooterIds[0]);
        } catch (Exception e) {
            if (context.isTransactionActive()) context.rollbackTransaction();
            System.err.println("Erro ao colocar scooter na doca: " + e.getMessage());
        }
    }

    private void about() {
        System.out.println("CITES Management DEMO");
        System.out.println("Group ID: 05");
        System.out.println("Members:");
        System.out.println("Guilherme Coutinho, nº50467");
        System.out.println("Francisco Tavares, nº51618");
        System.out.println("Andre Nunes, nº51766");
        System.out.println("DAL version:"+ isel.sisinf.jpa.Dal.version());
        System.out.println("Core version:"+ isel.sisinf.model.Core.version());
    }

    public void closeResources() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}

public class App{

    public static void main(String[] args) throws Exception{
        UI ui = UI.getInstance();
        try {
            ui.Run();
        } finally {
            ui.closeResources(); // Ensure resources are closed after execution
        }
    }
}