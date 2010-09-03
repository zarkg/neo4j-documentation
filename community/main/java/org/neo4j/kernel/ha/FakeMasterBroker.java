package org.neo4j.kernel.ha;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.ha.zookeeper.Machine;

public class FakeMasterBroker extends AbstractBroker
{
    public FakeMasterBroker( int myMachineId )
    {
        super( myMachineId );
    }
    
    public Machine getMasterMachine()
    {
        return new Machine( getMyMachineId(), 0, 1, null );
    }
    
    public Master getMaster()
    {
        throw new UnsupportedOperationException( "I am master" );
    }

    public boolean thisIsMaster()
    {
        return true;
    }
    
    public Object instantiateMasterServer( GraphDatabaseService graphDb )
    {
        return new MasterServer( new MasterImpl( graphDb ), CommunicationProtocol.PORT );
    }
}
