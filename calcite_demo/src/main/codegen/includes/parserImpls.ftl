SqlNode SqlCreateMaterializedView() :
{
    SqlParserPos pos;
    SqlIdentifier viewName;
    boolean existenceCheck = false;
    SqlSelect query;
}
{
    <CREATE> { pos = getPos(); }
    <MATERIALIZED> <VIEW>
        [ <IF> <NOT> <EXISTS> { existenceCheck = true; } ]

    viewName = CompoundIdentifier()
    <AS>
    query = SqlSelect()
    {
        return new CreateMaterializedView(pos, viewName, existenceCheck, query);
    }
}